package com.makethon.survey.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TextQuestion {
    private String questionString;
    private String ResponseChoices;
}
