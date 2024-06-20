package com.example.eventapp.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileEventListener {

    @EventListener
    public void onFileEventHandler(FileEvent fileEvent) {
            log.info("file event received type : {}, data : {}",fileEvent.getType(), fileEvent.getData());
    }
}
