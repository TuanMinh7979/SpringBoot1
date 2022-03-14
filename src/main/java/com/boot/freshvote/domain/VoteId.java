package com.boot.freshvote.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class VoteId implements Serializable {
    private static final long serialVersionUID = -4372361735684407638L;
    @ManyToOne
    private UserModel user;
    @ManyToOne
    private Feature feature;

}
