package it.isaura.emr.be.data;

/**
 * Created by pasquale on 18/06/2016.
 */
public interface EmrDataClient {


    String getData(String url);

    String getData(String url, Integer limit);

}
