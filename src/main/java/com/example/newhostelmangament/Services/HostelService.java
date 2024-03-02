package com.example.newhostelmangament.Services;

import com.example.newhostelmangament.Entity.Hostel;
import com.example.newhostelmangament.Repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {
    @Autowired
    private HostelRepository hostelRepository;
    // CRUD operations
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    public Hostel getHostelById(Long id) {
        return hostelRepository.findById(id).orElse(null);
    }

    public Hostel createHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    public Hostel updateHostel(Long id, Hostel hostelDetails) {
        Hostel hostel = hostelRepository.findById(id).orElse(null);
        if (hostel == null) {
            return null;
        }

        hostel.setName(hostelDetails.getName());
        // Update other fields as needed

        return hostelRepository.save(hostel);
    }

    public boolean deleteHostel(Long id) {
        Hostel hostel = hostelRepository.findById(id).orElse(null);
        if (hostel == null) {
            return false;
        }

        hostelRepository.delete(hostel);
        return true;
    }

}
