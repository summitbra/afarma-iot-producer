package com.afarma.mqtt.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PublishMsg {
    private Integer slotId;

    public PublishMsg() {
    }

    public PublishMsg(Integer slotId) {
        this.slotId = slotId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    @Override
    public String toString() {
        try {
            return  new ObjectMapper().writeValueAsString(this);
        }catch (JsonProcessingException e){
            return "PublishMsg{" +
                    "slotId=" + slotId +
                    '}';
        }
    }
}
