package com.kawa.api.model.projects.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.constants.Constants;
import com.kawa.api.model.projects.beans.ProjectBean;
import com.kawa.api.model.projects.constants.ProjectConstants;
import com.kawa.api.model.projects.exceptions.ProjectDescriptionTooLong;
import com.kawa.api.model.projects.exceptions.ProjectNameRequired;
import com.kawa.api.model.projects.exceptions.ProjectNameTooLong;
import com.kawa.api.model.projects.exceptions.ProjectNameTooSmall;
import com.kawa.api.model.projects.faces.IProject;
import com.kawa.api.model.projects.faces.IProjectFactory;
import com.kawa.api.model.projects.repositories.ProjectRepository;

/**
 * <b>Project</b> Factory.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class ProjectFactory implements IProjectFactory {

    /** Mapper. */
    private ModelMapper modelMapper;
    /** Repository. */
    private ProjectRepository projectRepository;

    /**
     * Constructor.
     * @param oProjectRepository Project Repository.
     * @since 0.1.0 hydrogen
     */
    public ProjectFactory(
            final ProjectRepository oProjectRepository) {
        this.modelMapper = new ModelMapper();
        this.projectRepository = oProjectRepository;
    }

    @Override
    public IProject create(
            final String sName,
            final String sDescription)
            throws ABusinessException, ATechnicalException {
        final ProjectBean oBean;

        /* Build new UUID. */
        final String uuid = UUID.randomUUID().toString();
        /* Retrieve & check the given name. */
        final String name = checkName(sName);
        /* Retrieve & check the given description. */
        final String description = checkDescription(sDescription);

        /* Build new bean. */
        oBean = new ProjectBean(uuid, name, description);

        /* Map the bean. */
        this.modelMapper.map(oBean, ProjectBean.class);

        /* Save the bean. */
        this.projectRepository.save(oBean);

        return new Project(oBean);
    }

    @Override
    public List<IProject> findAll()
            throws ABusinessException, ATechnicalException {
        final List<IProject> projects = new ArrayList<>();

        for (ProjectBean oBean : this.projectRepository.findAll()) {
            if (projects.size() >= ProjectConstants.MAX_NB_PROJECT) {
                return projects;
            }
            projects.add(new Project(oBean));
        }

        return projects;
    }

    @Override
    public void delete(final String sUUID)
            throws ABusinessException, ATechnicalException {
        this.projectRepository.deleteById(sUUID);
    }

    /**
     * Used to check a given project's name.
     * @param sCandidateName The given project's name.
     * @return A valid name.
     * @throws ProjectNameRequired if the given name is null.
     * @throws ProjectNameTooSmall if the given name  is too small.
     * @throws ProjectNameTooLong if the given name is too long.
     */
    private static String checkName(
        final String sCandidateName)
        throws ProjectNameRequired, ProjectNameTooSmall, ProjectNameTooLong {

        if (StringUtils.isBlank(sCandidateName)) {
            throw new ProjectNameRequired();
        }

       final String sTrimmed = sCandidateName.trim();

        if (sTrimmed.length() < ProjectConstants.NAME_MINIMUM_SIZE) {
            throw new ProjectNameTooSmall(sTrimmed.length());
        }
        if (sTrimmed.length() > ProjectConstants.NAME_MAXIMUM_SIZE) {
            throw new ProjectNameTooLong(sTrimmed.length());
        }
        return sTrimmed;
    }

    /**
     * Used to check a given project's description.
     * @param sCandidateDescription The given project's description.
     * @return A valid description.
     * @throws ProjectDescriptionTooLong if the given description is too long.
     * too long.
     */
    private static String checkDescription(
        final String sCandidateDescription)
        throws ProjectDescriptionTooLong {

        if (sCandidateDescription.length() > Constants.DEFAULT_MAXIMUM_LENGTH) {
            throw new ProjectDescriptionTooLong(sCandidateDescription.length());
        }
        return sCandidateDescription;
    }

    /**
     * Project Implementation.
     * <hr>
     *
     * @author <a href="https://github.com/old-papa-bear">
     * Nicolas "P.B." ROLLE</a>
     * @version 0.1.0 hydrogen
     */
    private static final class Project implements IProject {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Project Bean. */
        private final ProjectBean bean;

        /**
         * Constructor.
         * @param oBean Initial Bean.
         * @since 0.1.0 hydrogen
         */
        protected Project(final ProjectBean oBean) {
            this.bean = oBean;
        }

        @Override
        public int compareTo(final IProject o) {
            if (o == null) {
                return 1;
            }
            return StringUtils.compareIgnoreCase(
                    this.bean.getName(),
                    o.getName());
        }

        @Override
        public String getUuid() {
            return this.bean.getUuid();
        }

        @Override
        public String getName() {
            return this.bean.getName();
        }

        @Override
        public String getDescription() {
            return this.bean.getDescription();
        }

    }

}
