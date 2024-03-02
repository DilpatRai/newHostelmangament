package com.example.newhostelmangament.Services;


import com.example.newhostelmangament.Entity.Room;
import com.example.newhostelmangament.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    // CRUD operations
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            return null;
        }

        room.setNumber(roomDetails.getNumber());
        // Update other fields as needed

        return roomRepository.save(room);
    }

    public boolean deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            return false;
        }

        roomRepository.delete(room);
        return true;
    }
}