package org.triathlongirls.doranssam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.triathlongirls.doranssam.domain.diaries.Diary;
import org.triathlongirls.doranssam.domain.diaries.Text;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TextSaveRequestDto {
    @NotBlank
    private String originalText;

    @NotNull
    private boolean hasSynonym;

    private Text toEntity(Diary diary, String correctText, String highlightedText) {
        return Text.builder()
                .originalText(originalText)
                .correctText(correctText)
                .highlightedText(highlightedText)
                .hasSynonym(hasSynonym)
                .diary(diary)
                .build();
    }
}
