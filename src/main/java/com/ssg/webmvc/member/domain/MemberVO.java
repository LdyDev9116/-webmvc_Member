package com.ssg.webmvc.member.domain;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private String mid;
    private String mpw;
    private String email;
    private String mname;
    private LocalDate signdate;

}
