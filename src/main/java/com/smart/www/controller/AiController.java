package com.smart.www.controller;

import com.smart.www.agent.YuManus;
import com.smart.www.app.HealthApp;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private HealthApp healthApp;

    @Resource
    private ToolCallback[] allTools;

    @Resource
    private ChatModel dashscopeChatModel;

    @GetMapping("/health_app/chat/sync")
    public String doChatWithHealthAppSync(String message, String chatId) {
        return healthApp.doChat(message, chatId);
    }

    @GetMapping(value = "/health_app/chat/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> doChatWithHealthAppSSE(String message, String chatId) {
        return healthApp.doChatByStream(message, chatId);
    }

    @GetMapping(value = "/health_app/chat/sse/events")
    public Flux<ServerSentEvent<String>> doChatWithHealthAppSSEEvents(String message, String chatId) {
        return healthApp.doChatByStream(message, chatId)
                .map(chunk -> ServerSentEvent.<String>builder()
                        .data(chunk)
                        .build());
    }

    @GetMapping("/health_app/chat/sse/emitter")
    public SseEmitter doChatWithHealthAppSseEmitter(String message, String chatId) {
        // 创建一个超时时间较长的 SseEmitter
        SseEmitter emitter = new SseEmitter(180000L); // 3分钟超时
        // 获取 Flux 数据流并直接订阅
        healthApp.doChatByStream(message, chatId)
                .subscribe(
                        // 处理每条消息
                        chunk -> {
                            try {
                                emitter.send(chunk);
                            } catch (IOException e) {
                                emitter.completeWithError(e);
                            }
                        },
                        // 处理错误
                        emitter::completeWithError,
                        // 处理完成
                        emitter::complete
                );
        // 返回emitter
        return emitter;
    }


    /**
     * 流式调用 Manus 超级智能体
     *
     * @param message
     * @return
     */
    @GetMapping("/manus/chat")
    public SseEmitter doChatWithManus(String message) {
        YuManus yuManus = new YuManus(allTools, dashscopeChatModel);
        return yuManus.runStream(message);
    }

    /**
     * 支持开关的同步对话
     *
     * @param message            用户消息
     * @param chatId             会话ID
     * @param enableWebSearch    是否启用联网搜索（默认false）
     * @param enableDeepThinking 是否启用深度思考（默认false）
     * @return AI 回复内容
     */
    @GetMapping("/health_app/chat/advanced")
    public String doChatWithAdvancedOptions(
            String message,
            String chatId,
            @RequestParam(defaultValue = "false") boolean enableWebSearch,
            @RequestParam(defaultValue = "false") boolean enableDeepThinking) {
        return healthApp.doChatWithOptions(message, chatId, enableWebSearch, enableDeepThinking);
    }

    /**
     * 支持开关的流式对话
     *
     * @param message            用户消息
     * @param chatId             会话ID
     * @param enableWebSearch    是否启用联网搜索（默认false）
     * @param enableDeepThinking 是否启用深度思考（默认false）
     * @return 流式响应
     */
    @GetMapping(value = "/health_app/chat/advanced/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> doChatWithAdvancedOptionsStream(
            String message,
            String chatId,
            @RequestParam(defaultValue = "false") boolean enableWebSearch,
            @RequestParam(defaultValue = "false") boolean enableDeepThinking) {
        return healthApp.doChatByStreamWithOptions(message, chatId, enableWebSearch, enableDeepThinking);
    }

    /**
     * 支持开关的流式对话（SSE Emitter 方式）
     *
     * @param message            用户消息
     * @param chatId             会话ID
     * @param enableWebSearch    是否启用联网搜索（默认false）
     * @param enableDeepThinking 是否启用深度思考（默认false）
     * @return SseEmitter
     */
    @GetMapping("/health_app/chat/advanced/emitter")
    public SseEmitter doChatWithAdvancedOptionsEmitter(
            String message,
            String chatId,
            @RequestParam(defaultValue = "false") boolean enableWebSearch,
            @RequestParam(defaultValue = "false") boolean enableDeepThinking) {

        SseEmitter emitter = new SseEmitter(180000L); // 3分钟超时

        healthApp.doChatByStreamWithOptions(message, chatId, enableWebSearch, enableDeepThinking)
                .subscribe(
                        chunk -> {
                            try {
                                emitter.send(chunk);
                            } catch (IOException e) {
                                emitter.completeWithError(e);
                            }
                        },
                        emitter::completeWithError,
                        emitter::complete
                );

        return emitter;
    }

}
