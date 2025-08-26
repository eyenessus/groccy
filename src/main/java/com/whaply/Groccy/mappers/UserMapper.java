package com.whaply.Groccy.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.whaply.Groccy.dtos.requests.UserRequest;
import com.whaply.Groccy.dtos.requests.UserUpdate;
import com.whaply.Groccy.dtos.responses.UserResponse;
import com.whaply.Groccy.infrastructure.entities.User;


@Mapper(componentModel = "spring",unmappedTargetPolicy=ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequest userRequestDto);

    UserResponse toResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    void merge(UserUpdate userUpdate, @MappingTarget User user);
}
