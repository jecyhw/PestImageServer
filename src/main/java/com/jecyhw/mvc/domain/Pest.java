package com.jecyhw.mvc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jecyhw on 16-9-6.
 */
@Document(collection = "pest")
final public class Pest implements Serializable{
    @Id
    private String id;

    /**
     * 中文学名
     */
    @NotBlank
    @Indexed(unique = true)
    @Field("chinese_name")
    private String chineseName;

    /**
     * 拉丁学名
     */
    @Field("scientific_name")
    private String scientificName;

    /**
     * 界
     */
    private String kingdom;

    /**
     * 门
     */
    private String phylum;

    /**
     * 亚门
     */
    @Field("subphylum")
    private String subPhylum;

    /**
     * 纲
     */
    @Field("class")
    @JsonProperty("class")
    private String pestClass;

    /**
     * 亚纲
     */
    @Field("subclass")
    @JsonProperty("subClass")
    private String pestSubClass;

    /**
     * 目
     */
    private String order;

    /**
     * 亚目
     */
    @Field("suborder")
    private String subOrder;

    /**
     * 科
     */
    private String family;

    /**
     * 亚科
     */
    @Field("subfamily")
    private String subFamily;

    /**
     * 属
     */
    private String genus;

    /**
     * 亚属
     */
    @Field("subgenus")
    private String subGenus;

    /**
     * 种
     */
    private String species;

    /**
     * 亚种
     */
    @Field("subspecies")
    private String subSpecies;

    /**
     * 简介
     */
    @Field("brief_introduction")
    private String briefIntroduction;

    /**
     * 分布区域
     */
    @Field("distribution_area")
    private String distributionArea;

    /**
     * 形态特征
     */
    @Field("morphological_characteristic")
    private String morphologicalCharacteristic;

    /**
     * 发生规律
     */
    @Field("occurrence_rule")
    private String occurrenceRule;

    /**
     * 防治方法
     */
    @Field("prevention_method")
    private String preventionMethod;

    /**
     * 生活习性
     */
    @Field("living_habit")
    private String livingHabit;

    /**
     * 图片列表
     */

    private List<Picture> pictures;

    /**
     * 记录的来源.手工录入的人或者百度百科
     */
    private String source;

    @Field("deep_zoom")
    private DeepZoomMetaData deepZoom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getSubPhylum() {
        return subPhylum;
    }

    public void setSubPhylum(String subPhylum) {
        this.subPhylum = subPhylum;
    }

    public String getPestClass() {
        return pestClass;
    }

    public void setPestClass(String pestClass) {
        this.pestClass = pestClass;
    }

    public String getPestSubClass() {
        return pestSubClass;
    }

    public void setPestSubClass(String pestSubClass) {
        this.pestSubClass = pestSubClass;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSubOrder() {
        return subOrder;
    }

    public void setSubOrder(String subOrder) {
        this.subOrder = subOrder;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSubFamily() {
        return subFamily;
    }

    public void setSubFamily(String subFamily) {
        this.subFamily = subFamily;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSubGenus() {
        return subGenus;
    }

    public void setSubGenus(String subGenus) {
        this.subGenus = subGenus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getDistributionArea() {
        return distributionArea;
    }

    public void setDistributionArea(String distributionArea) {
        this.distributionArea = distributionArea;
    }

    public String getMorphologicalCharacteristic() {
        return morphologicalCharacteristic;
    }

    public void setMorphologicalCharacteristic(String morphologicalCharacteristic) {
        this.morphologicalCharacteristic = morphologicalCharacteristic;
    }

    public String getOccurrenceRule() {
        return occurrenceRule;
    }

    public void setOccurrenceRule(String occurrenceRule) {
        this.occurrenceRule = occurrenceRule;
    }

    public String getPreventionMethod() {
        return preventionMethod;
    }

    public void setPreventionMethod(String preventionMethod) {
        this.preventionMethod = preventionMethod;
    }

    public String getLivingHabit() {
        return livingHabit;
    }

    public void setLivingHabit(String livingHabit) {
        this.livingHabit = livingHabit;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public DeepZoomMetaData getDeepZoom() {
        return deepZoom;
    }

    public void setDeepZoom(DeepZoomMetaData deepZoom) {
        this.deepZoom = deepZoom;
    }
}
