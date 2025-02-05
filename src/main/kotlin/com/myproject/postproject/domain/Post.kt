package com.myproject.postproject.domain

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
class Post (

    @Id @GeneratedValue
    @Column(name = "post_id")
    var id: Long? = null,


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member? = null,

    var title :String? = null,

    var content :String? = null,

    var date :LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    var board: Board? = null

)