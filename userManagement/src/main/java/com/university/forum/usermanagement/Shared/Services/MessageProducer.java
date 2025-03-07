package com.university.forum.usermanagement.Shared.Services;

import com.university.forum.usermanagement.MemberManagement.Dtos.Message.ProfessorMessage;
import com.university.forum.usermanagement.MemberManagement.Models.Member;
import com.university.forum.usermanagement.MemberManagement.Models.Role;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName = "testQueue";
    private final String exchangeName = "member-management-exchange"; // Topic exchange


    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }



    public void sendMemberCreatedMessage(Member member, String memberType) {


        ProfessorMessage professorMessage=convertMemberToProfessorDto(member);
        Set<Integer> roleIds=member.getRoles().stream().map(Role::getId).collect(Collectors.toSet());
        professorMessage.setRoleIds(roleIds);
        String routingKey = "member." + memberType + ".created";

        rabbitTemplate.convertAndSend(exchangeName, routingKey, professorMessage);
        System.out.println("✅ Sent message to exchange with routing key [" + routingKey + "]: " + professorMessage);
    }


    public ProfessorMessage convertMemberToProfessorDto(Member member) {
        if (member == null) {
            return null;
        }
        ProfessorMessage professorMessage=new ProfessorMessage();

        professorMessage.setId(member.getId());
        professorMessage.setFirstName(member.getFirstName());
        professorMessage.setLastName(member.getLastName());
        professorMessage.setDob(member.getDob());
        professorMessage.setAddress(member.getAddress());
        professorMessage.setAddressEmail(member.getAddressEmail());
        professorMessage.setSex(member.getSex());
        professorMessage.setProfileImageUrl(member.getProfileImageUrl());
        professorMessage.setPhoneNumber(member.getPhoneNumber());
        professorMessage.setLinkedInProfileUrl(member.getLinkedInProfileUrl());
        professorMessage.setCin(member.getCin());

        return professorMessage;
    }
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("✅ Sent: " + message);
    }


}
