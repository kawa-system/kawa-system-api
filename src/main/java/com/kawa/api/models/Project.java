package com.kawa.api.models;

/**
 * ProjectModel.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
public class Project {
    private final String uuid;
    private String name;
    private String description;

    public Project(String uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public String getUuid() { return this.uuid; }
    public String getName() { return this.name; }
    public String getDescription() { return this.description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}