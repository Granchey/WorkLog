package core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WLConfiguration extends Configuration {

    @NotEmpty
    private String jwtSecretSignature;

    @Valid
    @NotNull
    private static DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        database = factory;
    }

    @JsonProperty("database")
    public static DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("jwtSecretSignature")
    public void setJwtSecretSignature(String jwtSecretSignature) {
        this.jwtSecretSignature = jwtSecretSignature;
    }

    @JsonProperty("jwtSecretSignature")
    public String getJwtSecretSignature() {
        return jwtSecretSignature;
    }
}