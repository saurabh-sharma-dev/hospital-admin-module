package com.hospital.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.admin.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}