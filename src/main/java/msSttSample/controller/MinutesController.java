package msSttSample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ishida.m
 */
@Controller
public class MinutesController {
    Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * ファイルを受け取ったらメッセージを返す
     * @param fileData バイナリ系ファイル
     * @return レスポンスメッセージ
     */
    @RequestMapping(value = "/sendVoice", method = RequestMethod.POST)
    Flux<Map<String, String>> receiveVoice(@RequestParam MultipartFile fileData) {
        String fileName = fileData.getOriginalFilename();
        log.info("received file: " + fileName);

        Map<String, String> payload = new HashMap<>();
        payload.put("message", "ファイルを受領しました。： " + fileName);

        return Flux.just(payload);
    }


    /**
     * ファイルを受け取ったらメッセージを返す
     * @param fileData バイナリ系ファイル
     * @return レスポンスメッセージ
     */
//    WebSocketClient client = new ReactorNettyWebSocketClient();
//    @PostMapping(path = "/fluxsample", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Flux<String> demo() {
//        Flux<WebSocketMessage> messages = Flux.create(sink -> {
//            Disposable receive = client.execute(URI.create("ws://demos.kaazing.com/echo"), headers,
//                    session -> {
//                        // Dummy request to start stream
//                        Disposable send = Flux.interval(Duration.ofMillis(500)).flatMap(i -> {
//                            WebSocketMessage message = session.textMessage("Hi " + i);
//                            return session.send(Mono.just(message));
//                        }).log("send").subscribe();
//                        return session.receive()
//                                .doOnNext(sink::next)
//                                .doOnError(sink::error)
//                                .doFinally(x -> {
//                                    send.dispose();
//                                    session.close();
//                                })
//                                .log("receive")
//                                .then();
//                    })
//                    .doOnError(sink::error)
//                    .subscribe();
//            sink.onCancel(receive);
//        });
//        return messages
//                .map(WebSocketMessage::getPayloadAsText)
//                .log("demo");
//    }

}
