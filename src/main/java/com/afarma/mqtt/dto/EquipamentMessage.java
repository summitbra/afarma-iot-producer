package com.afarma.mqtt.dto;

import com.fasterxml.jackson.databind.ObjectMapper;



public class EquipamentMessage {
    private String deviceId;
    private String deviceModel;
    private boolean medicine;
    private Integer slotId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public boolean isMedicine() {
        return medicine;
    }

    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
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
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            return "EquipamentMessage [deviceId=" + deviceId + ", deviceModel=" + deviceModel + ", medicine=" + medicine
            + ", slotId=" + slotId + "]";
        }
    }

    
}
