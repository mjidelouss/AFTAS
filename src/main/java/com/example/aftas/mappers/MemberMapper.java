package com.example.aftas.mappers;

import com.example.aftas.VMs.request.MemberRequest;
import com.example.aftas.VMs.response.MemberResponse;
import com.example.aftas.entities.Member;

public class MemberMapper {

    public static Member mapMemberRequestToMember(MemberRequest memberRequest) {
        return new Member().builder()
                .name(memberRequest.getName())
                .familyName(memberRequest.getFamilyName())
                .nationality(memberRequest.getNationality())
                .identityNumber(memberRequest.getIdentityNumber())
                .identityDocumentType(memberRequest.getIdentityDocumentType())
                .build();
    }

    public static MemberResponse mapMemberToMemberResponse(Member member) {
        return new MemberResponse().builder()
                .membershipNumber(member.getMembershipNumber())
                .name(member.getName())
                .familyName(member.getFamilyName())
                .nationality(member.getNationality())
                .build()
    }
}
