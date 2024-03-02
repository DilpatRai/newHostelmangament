package com.example.newhostelmangament.Controller;


import com.example.newhostelmangament.Entity.Hostel;
import com.example.newhostelmangament.Services.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/hostels")
public class HostelController {
    @Autowired
    private HostelService hostelService;
    // CRUD endpoints
    @GetMapping
    public List<Hostel> getAllHostels() {
        return hostelService.getAllHostels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hostel> getHostelById(@PathVariable Long id) {
        Hostel hostel = hostelService.getHostelById(id);
        if (hostel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(hostel);
    }

    @PostMapping
    public ResponseEntity<Hostel> createHostel(@RequestBody Hostel hostel) {
        Hostel createdHostel = hostelService.createHostel(hostel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHostel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hostel> updateHostel(@PathVariable Long id, @RequestBody Hostel hostelDetails) {
        Hostel updatedHostel = hostelService.updateHostel(id, hostelDetails);
        if (updatedHostel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedHostel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHostel(@PathVariable Long id) {
        boolean deleted = hostelService.deleteHostel(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
