package com.makethon.survey.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TextRadioQuestion {
    private String questionString;
    private List<String> ResponseChoices;
}
