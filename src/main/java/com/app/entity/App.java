package com.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "App")
public class App extends Base {
    private long processId;
    private String title;
    private String processName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<State> states = new ArrayList<>();

    public App(long processId, String title, String processName) {
        this.processId = processId;
        this.title = title;
        this.processName = processName;
    }

    public App(String title, String processName) {
        this.title = title;
        this.processName = processName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof App)) return false;

        App app = (App) o;

        if (!getTitle().equals(app.getTitle())) return false;
        return getProcessName().equals(app.getProcessName());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getProcessName().hashCode();
        return result;
    }
}
