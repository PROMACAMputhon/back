package com.dongguk.campton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponseDto {
    private Long room_id;
    private Integer room_type;
    private String room_title;

}
