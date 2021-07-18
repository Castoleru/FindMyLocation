package edu.utcn.gpstrack.server.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping
    public Position create(@RequestBody Position position) {
        return positionService.create(position);
    }

    @GetMapping("/{id}")
    public Position read(@PathVariable Integer id) {
        return positionService.read(id);
    }

    @PutMapping("{id}")
    public Position update(@RequestBody Position newPosition, @PathVariable Integer id) {
        return positionService.update(newPosition, id);
    }

    @DeleteMapping("/{id}")
    public Position delete(@PathVariable Integer id) {
        return positionService.delete(id);
    }
    // Controler Advice
}
