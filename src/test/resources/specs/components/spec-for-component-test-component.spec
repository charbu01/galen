

========================================

user-pic        css .user-pic
user-name       css a.user-name
user-age        css span.age

========================================

@ mobile
------------------
user-pic
    width: 70 px
    height: 70 px
    inside: parent ~ 20 px top left
 
@ all, nomobile  
------------------ 
user-name
    height: 15 to 25 px
    inside: parent ~ 20 px top
    near: user-pic ~ 10 px right
    
@ all
------------------
user-age
    height: 15 to 25 px
    near: user-pic ~ 10px right
    below: user-name 0 to 10px 