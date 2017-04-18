package za.co.discovery.repository.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * Created by tinashehondo on 4/17/17.
 */
public class CsvFileReaderUtil {
    private static final Logger logger = LoggerFactory.getLogger(CsvFileReaderUtil.class);

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            InputStream inputStream = classPathResource.getInputStream();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(inputStream);
            return readValues.readAll();
        } catch (Exception e) {
            logger.error("error processing file upload {}",e);
            return Collections.emptyList();
        }
    }


    public List<Planet> getPlanets() {
        return new CsvFileReaderUtil().loadObjectList(Planet.class, "/planet.csv");
    }

    public List<Route> getRoutes() {
        return new CsvFileReaderUtil().loadObjectList(Route.class, "/route.csv");
    }


}
