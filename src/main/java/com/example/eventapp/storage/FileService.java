package com.example.eventapp.storage;

import com.example.eventapp.event.FileEvent;
import com.example.eventapp.event.FileEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
        try {
            log.info("file copied");
            log.info("DB file mata info saved");
            FileEvent completeEvent = FileEvent.toCompleteEvent(data);
            fileEventPublisher.notifyComplete(completeEvent);
        } catch(Exception e) {
            log.error("file upload fail", e);
            FileEvent errorEvent = FileEvent.toErrrorEvent(data);
            fileEventPublisher.notifyError(errorEvent);
        }
    }
}
