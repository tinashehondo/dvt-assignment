package za.co.discovery.repository.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tinashehondo on 4/17/17.
 */
public class CsvFileReaderUtil {

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();

            ClassPathResource classPathResource = new ClassPathResource(fileName);

            InputStream inputStream = classPathResource.getInputStream();

           // File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(inputStream);
            return readValues.readAll();
        } catch (Exception e) {

            System.out.print("Error occurred while loading object list from file " + fileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<String[]> loadManyToManyRelationship(String fileName) {
        try {
            CsvMapper mapper = new CsvMapper();
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);

           ClassPathResource classPathResource = new ClassPathResource(fileName);

            InputStream inputStream = classPathResource.getInputStream();


            File targetFile = new File("route_tmp.csv");

            FileUtils.copyInputStreamToFile(inputStream, targetFile);

           // File file = new ClassPathResource(fileName).getFile();
            MappingIterator<String[]> readValues =
                    mapper.reader(String[].class).with(bootstrapSchema).readValue(targetFile);
            return readValues.readAll();
        } catch (Exception e) {
            System.out.print(
                    "Error occurred while loading many to many relationship from file = " + fileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public List<Planet> getPlanets(){
       return new CsvFileReaderUtil().loadObjectList(Planet.class,"/planet.csv");
    }
    public List<Route> getRoutes(){
        return new CsvFileReaderUtil().loadObjectList(Route.class,"/route.csv");
    }
    public List<Route> getRoutesManyToMany(){

        List<String[]> result = new CsvFileReaderUtil().loadManyToManyRelationship("/route.csv");

        List<Route> routeList = new ArrayList<Route>();

        for (String[] s: result)
        {
            Route route = new Route();

            Planet origin = new Planet();
            origin.setNode(s[1]);
            Planet destination = new Planet();
            destination.setNode(s[2]);

            route.setRouteId(Integer.parseInt(s[0]));
            route.setDistance(Double.parseDouble(s[3]));
            route.setOrigin(origin);
            route.setDestination(destination);

            routeList.add(route);
        }
        return routeList;
    }




    public static void main(String[] args) {
       // System.out.print("########"+new CsvFileReaderUtil().loadObjectList(Planet.class,"planet.csv"));
       // System.out.print("########"+new CsvFileReaderUtil().loadManyToManyRelationship("route.csv"));

        System.out.print("########"+new CsvFileReaderUtil().loadObjectList(Route.class,"route.csv"));




       // System.out.print("####Routes####"+new CsvFileReaderUtil().getRoutes());


    }
}
