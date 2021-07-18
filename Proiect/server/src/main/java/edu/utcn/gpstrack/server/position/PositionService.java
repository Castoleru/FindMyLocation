package edu.utcn.gpstrack.server.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Position create(Position position) {
        if(position.getId() != null)
            return  null;
        if(position.getCreationDate() != null)
            return null;
        return positionRepository.save(position);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Position read(Integer id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Position update(Position newPosition, Integer id) {
        return positionRepository.findById(id)
                .map(position ->{
                    position.setLongitude(newPosition.getLongitude());
                    position.setLatitude(newPosition.getLatitude());
                    position.setTerminalId(newPosition.getTerminalId());
                    return positionRepository.save(position);
                } ).orElse(null);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Position delete(Integer id) {
        // Mai intai gasesc pozitia si dupa o sterg
        Optional<Position> deletePos = positionRepository.findById(id);
        deletePos.orElseThrow(()->new IllegalArgumentException("The id does not exist!"));
        return deletePos.get();
    }

}
