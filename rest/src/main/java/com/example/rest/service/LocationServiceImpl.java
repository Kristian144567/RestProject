package com.example.rest.service;
import com.example.rest.repository.LocationRepository;
import com.example.rest.model.location.Location;
import com.example.rest.model.location.CreateLocation;
import com.example.rest.model.location.UpdateLocation;
import com.example.rest.model.location.ResponseLocation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locations;
    private ResponseLocation responce;
    @Autowired
    public LocationServiceImpl(LocationRepository locations) {
        this.locations = locations;
    }

    @Override
    public ResponseLocation create(CreateLocation create) {
        Location location = new Location();

        BeanUtils.copyProperties(create, location);
        Location save = this.locations.save(location);
        return LocationRepository.responseGenerate(save);
    }
    public Boolean delete(Long id) {
        if (locations.existsById(id)) {
            locations.deleteById(id);
            return true;
        }
        return false;
    }
    public List<ResponseLocation> findAll() {
        List<Location> locations = this.locations.findAll();

        return locations.stream()
                .map(location -> {
                    ResponseLocation response = new ResponseLocation();
                    BeanUtils.copyProperties(location, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

    public ResponseLocation findById(Long id) {
        Optional<Location> optional = locations.findById(id);

        return optional.map(location -> {
            ResponseLocation response = new ResponseLocation();
            BeanUtils.copyProperties(location, response);
            return response;
        }).orElse(null);
    }

    public ResponseLocation update(UpdateLocation update) {
        Optional<Location> locationOptional = locations.findById(update.getId());
        if (!locationOptional.isPresent()) {
            return null;
        }else {
            Location location = locationOptional.get();
            BeanUtils.copyProperties(update, location);
            Location updateLocation = locations.save(location);
            return LocationRepository.responseGenerate(updateLocation);
        }

    }

}
