package com.iana.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;
 
@XmlRootElement(name = "Greeting")
@XmlType(propOrder = {"id", "content"})
@JsonPropertyOrder({"id", "content"})
public class Greeting {
 
	@XmlElement
    private long id;
	
	@XmlElement
    private String content;
	
	
	public Greeting() {
		 
	}
 
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
 
    public long getId() {
        return id;
    }
 
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getContent() {
        return content;
    }
}