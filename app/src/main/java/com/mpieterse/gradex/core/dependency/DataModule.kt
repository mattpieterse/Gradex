package com.mpieterse.gradex.core.dependency

import android.content.Context
import com.mpieterse.gradex.core.contexts.AppDatabase
import com.mpieterse.gradex.core.daos.DegreeDao
import com.mpieterse.gradex.core.daos.GradeDao
import com.mpieterse.gradex.core.daos.LectureDao
import com.mpieterse.gradex.core.daos.ProjectDao
import com.mpieterse.gradex.core.daos.StudentDao
import com.mpieterse.gradex.core.daos.SubjectDao
import com.mpieterse.gradex.core.daos.SubjectTeacherDao
import com.mpieterse.gradex.core.daos.TeacherCellContactDao
import com.mpieterse.gradex.core.daos.TeacherDao
import com.mpieterse.gradex.core.daos.TeacherMailContactDao
import com.mpieterse.gradex.core.daos.TermDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    /**
     * Injects the [AppDatabase] instance.
     *
     * @return [AppDatabase]
     */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)


// --- Data Access Objects (DAOs)


    /**
     * Injects the [DegreeDao] instance.
     *
     * @return [DegreeDao]
     */
    @Provides
    @Singleton
    fun provideDegreeDao(appDatabase: AppDatabase): DegreeDao {
        return appDatabase.degreeDao()
    }


    /**
     * Injects the [GradeDao] instance.
     *
     * @return [GradeDao]
     */
    @Provides
    @Singleton
    fun provideGradeDao(appDatabase: AppDatabase): GradeDao {
        return appDatabase.gradeDao()
    }


    /**
     * Injects the [LectureDao] instance.
     *
     * @return [LectureDao]
     */
    @Provides
    @Singleton
    fun provideLectureDao(appDatabase: AppDatabase): LectureDao {
        return appDatabase.lectureDao()
    }


    /**
     * Injects the [ProjectDao] instance.
     *
     * @return [ProjectDao]
     */
    @Provides
    @Singleton
    fun provideProjectDao(appDatabase: AppDatabase): ProjectDao {
        return appDatabase.projectDao()
    }


    /**
     * Injects the [StudentDao] instance.
     *
     * @return [StudentDao]
     */
    @Provides
    @Singleton
    fun provideStudentDao(appDatabase: AppDatabase): StudentDao {
        return appDatabase.studentDao()
    }


    /**
     * Injects the [SubjectDao] instance.
     *
     * @return [SubjectDao]
     */
    @Provides
    @Singleton
    fun provideSubjectDao(appDatabase: AppDatabase): SubjectDao {
        return appDatabase.subjectDao()
    }


    /**
     * Injects the [SubjectTeacherDao] instance.
     *
     * @return [SubjectTeacherDao]
     */
    @Provides
    @Singleton
    fun provideSubjectTeacherDao(appDatabase: AppDatabase): SubjectTeacherDao {
        return appDatabase.subjectTeacherDao()
    }


    /**
     * Injects the [TeacherDao] instance.
     *
     * @return [TeacherDao]
     */
    @Provides
    @Singleton
    fun provideTeacherDao(appDatabase: AppDatabase): TeacherDao {
        return appDatabase.teacherDao()
    }


    /**
     * Injects the [TeacherCellContactDao] instance.
     *
     * @return [TeacherCellContactDao]
     */
    @Provides
    @Singleton
    fun provideTeacherCellContactDao(appDatabase: AppDatabase): TeacherCellContactDao {
        return appDatabase.teacherCellContactDao()
    }


    /**
     * Injects the [TeacherMailContactDao] instance.
     *
     * @return [TeacherMailContactDao]
     */
    @Provides
    @Singleton
    fun provideTeacherMailContactDao(appDatabase: AppDatabase): TeacherMailContactDao {
        return appDatabase.teacherMailContactDao()
    }


    /**
     * Injects the [TermDao] instance.
     *
     * @return [TermDao]
     */
    @Provides
    @Singleton
    fun provideTermDao(appDatabase: AppDatabase): TermDao {
        return appDatabase.termDao()
    }
}