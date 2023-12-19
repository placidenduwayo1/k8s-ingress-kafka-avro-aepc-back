/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Company extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8708131111978976779L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Company\",\"namespace\":\"com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans\",\"fields\":[{\"name\":\"companyId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"agency\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"connectedDate\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Company> ENCODER =
      new BinaryMessageEncoder<Company>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Company> DECODER =
      new BinaryMessageDecoder<Company>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Company> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Company> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Company> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Company>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Company to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Company from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Company instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Company fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String companyId;
  private java.lang.String name;
  private java.lang.String agency;
  private java.lang.String type;
  private java.lang.String connectedDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Company() {}

  /**
   * All-args constructor.
   * @param companyId The new value for companyId
   * @param name The new value for name
   * @param agency The new value for agency
   * @param type The new value for type
   * @param connectedDate The new value for connectedDate
   */
  public Company(java.lang.String companyId, java.lang.String name, java.lang.String agency, java.lang.String type, java.lang.String connectedDate) {
    this.companyId = companyId;
    this.name = name;
    this.agency = agency;
    this.type = type;
    this.connectedDate = connectedDate;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return companyId;
    case 1: return name;
    case 2: return agency;
    case 3: return type;
    case 4: return connectedDate;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: companyId = value$ != null ? value$.toString() : null; break;
    case 1: name = value$ != null ? value$.toString() : null; break;
    case 2: agency = value$ != null ? value$.toString() : null; break;
    case 3: type = value$ != null ? value$.toString() : null; break;
    case 4: connectedDate = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'companyId' field.
   * @return The value of the 'companyId' field.
   */
  public java.lang.String getCompanyId() {
    return companyId;
  }


  /**
   * Sets the value of the 'companyId' field.
   * @param value the value to set.
   */
  public void setCompanyId(java.lang.String value) {
    this.companyId = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.String getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'agency' field.
   * @return The value of the 'agency' field.
   */
  public java.lang.String getAgency() {
    return agency;
  }


  /**
   * Sets the value of the 'agency' field.
   * @param value the value to set.
   */
  public void setAgency(java.lang.String value) {
    this.agency = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.String getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.String value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'connectedDate' field.
   * @return The value of the 'connectedDate' field.
   */
  public java.lang.String getConnectedDate() {
    return connectedDate;
  }


  /**
   * Sets the value of the 'connectedDate' field.
   * @param value the value to set.
   */
  public void setConnectedDate(java.lang.String value) {
    this.connectedDate = value;
  }

  /**
   * Creates a new Company RecordBuilder.
   * @return A new Company RecordBuilder
   */
  public static com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder newBuilder() {
    return new com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder();
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Company RecordBuilder
   */
  public static com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder newBuilder(com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder other) {
    if (other == null) {
      return new com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder();
    } else {
      return new com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder(other);
    }
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Company instance.
   * @param other The existing instance to copy.
   * @return A new Company RecordBuilder
   */
  public static com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder newBuilder(com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company other) {
    if (other == null) {
      return new com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder();
    } else {
      return new com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder(other);
    }
  }

  /**
   * RecordBuilder for Company instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Company>
    implements org.apache.avro.data.RecordBuilder<Company> {

    private java.lang.String companyId;
    private java.lang.String name;
    private java.lang.String agency;
    private java.lang.String type;
    private java.lang.String connectedDate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.companyId)) {
        this.companyId = data().deepCopy(fields()[0].schema(), other.companyId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.agency)) {
        this.agency = data().deepCopy(fields()[2].schema(), other.agency);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.connectedDate)) {
        this.connectedDate = data().deepCopy(fields()[4].schema(), other.connectedDate);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing Company instance
     * @param other The existing instance to copy.
     */
    private Builder(com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.companyId)) {
        this.companyId = data().deepCopy(fields()[0].schema(), other.companyId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.agency)) {
        this.agency = data().deepCopy(fields()[2].schema(), other.agency);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.type)) {
        this.type = data().deepCopy(fields()[3].schema(), other.type);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.connectedDate)) {
        this.connectedDate = data().deepCopy(fields()[4].schema(), other.connectedDate);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'companyId' field.
      * @return The value.
      */
    public java.lang.String getCompanyId() {
      return companyId;
    }


    /**
      * Sets the value of the 'companyId' field.
      * @param value The value of 'companyId'.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder setCompanyId(java.lang.String value) {
      validate(fields()[0], value);
      this.companyId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'companyId' field has been set.
      * @return True if the 'companyId' field has been set, false otherwise.
      */
    public boolean hasCompanyId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'companyId' field.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder clearCompanyId() {
      companyId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder setName(java.lang.String value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'agency' field.
      * @return The value.
      */
    public java.lang.String getAgency() {
      return agency;
    }


    /**
      * Sets the value of the 'agency' field.
      * @param value The value of 'agency'.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder setAgency(java.lang.String value) {
      validate(fields()[2], value);
      this.agency = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'agency' field has been set.
      * @return True if the 'agency' field has been set, false otherwise.
      */
    public boolean hasAgency() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'agency' field.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder clearAgency() {
      agency = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.String getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder setType(java.lang.String value) {
      validate(fields()[3], value);
      this.type = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder clearType() {
      type = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'connectedDate' field.
      * @return The value.
      */
    public java.lang.String getConnectedDate() {
      return connectedDate;
    }


    /**
      * Sets the value of the 'connectedDate' field.
      * @param value The value of 'connectedDate'.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder setConnectedDate(java.lang.String value) {
      validate(fields()[4], value);
      this.connectedDate = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'connectedDate' field has been set.
      * @return True if the 'connectedDate' field has been set, false otherwise.
      */
    public boolean hasConnectedDate() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'connectedDate' field.
      * @return This builder.
      */
    public com.placide.k8skafkaavroaepccleanarchibsmicrosproject.domain.avrobeans.Company.Builder clearConnectedDate() {
      connectedDate = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Company build() {
      try {
        Company record = new Company();
        record.companyId = fieldSetFlags()[0] ? this.companyId : (java.lang.String) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
        record.agency = fieldSetFlags()[2] ? this.agency : (java.lang.String) defaultValue(fields()[2]);
        record.type = fieldSetFlags()[3] ? this.type : (java.lang.String) defaultValue(fields()[3]);
        record.connectedDate = fieldSetFlags()[4] ? this.connectedDate : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Company>
    WRITER$ = (org.apache.avro.io.DatumWriter<Company>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Company>
    READER$ = (org.apache.avro.io.DatumReader<Company>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.companyId);

    out.writeString(this.name);

    out.writeString(this.agency);

    out.writeString(this.type);

    out.writeString(this.connectedDate);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.companyId = in.readString();

      this.name = in.readString();

      this.agency = in.readString();

      this.type = in.readString();

      this.connectedDate = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.companyId = in.readString();
          break;

        case 1:
          this.name = in.readString();
          break;

        case 2:
          this.agency = in.readString();
          break;

        case 3:
          this.type = in.readString();
          break;

        case 4:
          this.connectedDate = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









