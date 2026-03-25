package com.hospital.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.admin.entity.Room;
import com.hospital.admin.service.RoomService;

@RestController
@RequestMapping("/api/admin")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return service.getAllRooms();
    }

    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room) {
        return service.saveRoom(room);
    }

    @PatchMapping("/rooms/{roomNumber}/status")
    public String updateRoomStatus(@PathVariable String roomNumber,
                                  @RequestParam String status) {
        service.updateRoomStatus(roomNumber, status);
        return "Room status updated";
    }

    @GetMapping("/rooms/hospital/{hospitalId}")
    public List<Room> getRoomsByHospital(@PathVariable Long hospitalId) {
        return service.getRoomsByHospitalId(hospitalId);
    }
}