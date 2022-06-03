package com.example.gm.dto;

import javax.validation.constraints.NotEmpty;

public class ZapisDTO {
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    @NotEmpty
    private String email;
    @NotEmpty
    private String title;
    private String address;

    public ZapisDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotEmpty String getDate() {
        return this.date;
    }

    public @NotEmpty String getTime() {
        return this.time;
    }

    public @NotEmpty String getEmail() {
        return this.email;
    }

    public @NotEmpty String getTitle() {
        return this.title;
    }

    public String getAddress() {
        return this.address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(@NotEmpty String date) {
        this.date = date;
    }

    public void setTime(@NotEmpty String time) {
        this.time = time;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public void setTitle(@NotEmpty String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ZapisDTO)) return false;
        final ZapisDTO other = (ZapisDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$time = this.getTime();
        final Object other$time = other.getTime();
        if (this$time == null ? other$time != null : !this$time.equals(other$time)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ZapisDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $time = this.getTime();
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    public String toString() {
        return "ZapisDTO(id=" + this.getId() + ", date=" + this.getDate() + ", time=" + this.getTime() + ", email=" + this.getEmail() + ", title=" + this.getTitle() + ", address=" + this.getAddress() + ")";
    }
}
