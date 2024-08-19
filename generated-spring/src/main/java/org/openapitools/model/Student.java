package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * StudentEntity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-15T10:16:09.175345+01:00[Europe/London]", comments = "Generator version: 7.7.0")
public class Student {

  private Integer id;

  private String lastName;

  private String firstMidName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate enrollmentDate;

  public Student id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Student lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   */
  
  @Schema(name = "lastName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student firstMidName(String firstMidName) {
    this.firstMidName = firstMidName;
    return this;
  }

  /**
   * Get firstMidName
   * @return firstMidName
   */
  
  @Schema(name = "firstMidName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstMidName")
  public String getFirstMidName() {
    return firstMidName;
  }

  public void setFirstMidName(String firstMidName) {
    this.firstMidName = firstMidName;
  }

  public Student enrollmentDate(LocalDate enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
    return this;
  }

  /**
   * Get enrollmentDate
   * @return enrollmentDate
   */
  @Valid 
  @Schema(name = "enrollmentDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrollmentDate")
  public LocalDate getEnrollmentDate() {
    return enrollmentDate;
  }

  public void setEnrollmentDate(LocalDate enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) &&
        Objects.equals(this.lastName, student.lastName) &&
        Objects.equals(this.firstMidName, student.firstMidName) &&
        Objects.equals(this.enrollmentDate, student.enrollmentDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, firstMidName, enrollmentDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentEntity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstMidName: ").append(toIndentedString(firstMidName)).append("\n");
    sb.append("    enrollmentDate: ").append(toIndentedString(enrollmentDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

