/*
 * Copyright (c) 2013-2018, Centre for Genomic Regulation (CRG).
 * Copyright (c) 2013-2018, Paolo Di Tommaso and the respective authors.
 *
 *   This file is part of 'Nextflow'.
 *
 *   Nextflow is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Nextflow is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Nextflow.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * task_execution.proto
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: version not set
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nextflow.ga4gh.tes.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Output describes Task output files.
 */
@ApiModel(description = "Output describes Task output files.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-01T15:43:49.638Z")
public class TesOutput {
  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("url")
  private String url = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("type")
  private TesFileType type = null;

  public TesOutput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TesOutput description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TesOutput url(String url) {
    this.url = url;
    return this;
  }

   /**
   * URL in long term storage, for example: s3://my-object-store/file1 gs://my-bucket/file2 file:///path/to/my/file /path/to/my/file etc...
   * @return url
  **/
  @ApiModelProperty(value = "URL in long term storage, for example: s3://my-object-store/file1 gs://my-bucket/file2 file:///path/to/my/file /path/to/my/file etc...")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public TesOutput path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path of the file inside the container. Must be an absolute path.
   * @return path
  **/
  @ApiModelProperty(value = "Path of the file inside the container. Must be an absolute path.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public TesOutput type(TesFileType type) {
    this.type = type;
    return this;
  }

   /**
   * Type of the file, FILE or DIRECTORY
   * @return type
  **/
  @ApiModelProperty(value = "Type of the file, FILE or DIRECTORY")
  public TesFileType getType() {
    return type;
  }

  public void setType(TesFileType type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TesOutput tesOutput = (TesOutput) o;
    return Objects.equals(this.name, tesOutput.name) &&
        Objects.equals(this.description, tesOutput.description) &&
        Objects.equals(this.url, tesOutput.url) &&
        Objects.equals(this.path, tesOutput.path) &&
        Objects.equals(this.type, tesOutput.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, url, path, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TesOutput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

