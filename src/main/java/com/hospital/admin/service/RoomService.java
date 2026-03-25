
package com.hospital.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.admin.entity.Room;
import com.hospital.admin.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public List<Room> getAllRooms() {
        return repository.findAll();
    }
    public Room saveRoom(Room room) {
        return repository.save(room);
    }

    public List<Room> getRoomsByHospitalId(Long hospitalId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateRoomStatus(String roomNumber, String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}