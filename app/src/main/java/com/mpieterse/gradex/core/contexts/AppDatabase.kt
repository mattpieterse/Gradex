package com.mpieterse.gradex.core.contexts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mpieterse.gradex.core.converters.EnumConverter
import com.mpieterse.gradex.core.converters.TimeConverter
import com.mpieterse.gradex.core.converters.UuidConverter
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
import com.mpieterse.gradex.core.models.data.Degree
import com.mpieterse.gradex.core.models.data.Grade
import com.mpieterse.gradex.core.models.data.Lecture
import com.mpieterse.gradex.core.models.data.Project
import com.mpieterse.gradex.core.models.data.Student
import com.mpieterse.gradex.core.models.data.Subject
import com.mpieterse.gradex.core.models.data.SubjectTeacher
import com.mpieterse.gradex.core.models.data.Teacher
import com.mpieterse.gradex.core.models.data.TeacherCellContact
import com.mpieterse.gradex.core.models.data.TeacherMailContact
import com.mpieterse.gradex.core.models.data.Term
import com.mpieterse.gradex.core.utils.Clogger

/**
 * Local application-level database.
 *
 * @property AppDatabase.degreeDao
 * @property AppDatabase.gradeDao
 * @property AppDatabase.lectureDao
 * @property AppDatabase.projectDao
 * @property AppDatabase.studentDao
 * @property AppDatabase.subjectDao
 * @property AppDatabase.subjectTeacherDao
 * @property AppDatabase.teacherDao
 * @property AppDatabase.teacherCellContactDao
 * @property AppDatabase.teacherMailContactDao
 * @property AppDatabase.termDao
 */
@Database(
    entities = [
        Degree::class,
        Grade::class,
        Lecture::class,
        Project::class,
        Student::class,
        Subject::class,
        SubjectTeacher::class,
        Teacher::class,
        TeacherCellContact::class,
        TeacherMailContact::class,
        Term::class,
    ],

    // -- Configuration
    exportSchema = true,
    version = 1,
)
@TypeConverters(
    UuidConverter::class,
    TimeConverter::class,
    EnumConverter::class,
)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        private const val DATABASE_NAME = "gradex.db"
        private const val TAG = "AppDatabase"

        /**
         * Singleton instance of the [AppDatabase].
         */
        fun getInstance(context: Context): AppDatabase {
            Clogger.i(
                TAG, "Constructing database..."
            )

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, DATABASE_NAME
                ).build()
                Clogger.i(
                    TAG, "Singleton database instance generated."
                )

                INSTANCE = instance
                instance
            }
        }
    }


    // --- DAO Accessors
    
    
    abstract fun degreeDao(): DegreeDao
    abstract fun gradeDao(): GradeDao
    abstract fun lectureDao(): LectureDao
    abstract fun projectDao(): ProjectDao
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
    abstract fun subjectTeacherDao(): SubjectTeacherDao
    abstract fun teacherDao(): TeacherDao
    abstract fun teacherCellContactDao(): TeacherCellContactDao
    abstract fun teacherMailContactDao(): TeacherMailContactDao
    abstract fun termDao(): TermDao
}