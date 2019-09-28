package com.makethon.survey.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ImageQuestion {
    private String questionString;
    private byte[] questionImage;
    private String stringResponse;
}
