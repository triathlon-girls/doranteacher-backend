package org.triathlongirls.doranssam.domain.diaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "diary_img")
public class DiaryImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_img_id")
    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private Boolean isSelected;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public void updateDiaryImg(
            String oriImgName,
            String imgName,
            String imgUrl,
            Boolean isSelected
    ) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.isSelected = isSelected;
    }

    public void selectDiaryImg() {this.isSelected = true;}
}
