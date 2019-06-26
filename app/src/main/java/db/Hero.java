package db;

import org.litepal.crud.DataSupport;

public class Hero extends DataSupport {

    private int id;

    private String ImageUrl;      //英雄图片

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    private String designNation;   //英雄称号,如:暗裔剑魔

    private String name;           //英雄姓名,如:亚托克斯

    private String englishName;    //英雄英文名,如:Aatrox

    public Hero(String imageUrl,String designNation,String name,String englishName){
        this.ImageUrl = imageUrl;
        this.designNation = designNation;
        this.name = name;
        this.englishName = englishName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignNation() {
        return designNation;
    }

    public void setDesignNation(String designNation) {
        this.designNation = designNation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
}
