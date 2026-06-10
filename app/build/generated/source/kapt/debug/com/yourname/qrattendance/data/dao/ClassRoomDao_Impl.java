package com.yourname.qrattendance.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.yourname.qrattendance.data.entities.ClassRoom;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ClassRoomDao_Impl implements ClassRoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ClassRoom> __insertionAdapterOfClassRoom;

  private final EntityDeletionOrUpdateAdapter<ClassRoom> __deletionAdapterOfClassRoom;

  private final EntityDeletionOrUpdateAdapter<ClassRoom> __updateAdapterOfClassRoom;

  public ClassRoomDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClassRoom = new EntityInsertionAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `classes` (`id`,`name`,`subject`,`teacherId`,`classCode`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSubject() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSubject());
        }
        statement.bindLong(4, entity.getTeacherId());
        if (entity.getClassCode() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getClassCode());
        }
      }
    };
    this.__deletionAdapterOfClassRoom = new EntityDeletionOrUpdateAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `classes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfClassRoom = new EntityDeletionOrUpdateAdapter<ClassRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `classes` SET `id` = ?,`name` = ?,`subject` = ?,`teacherId` = ?,`classCode` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassRoom entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getSubject() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSubject());
        }
        statement.bindLong(4, entity.getTeacherId());
        if (entity.getClassCode() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getClassCode());
        }
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object insertClass(final ClassRoom classRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfClassRoom.insert(classRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteClass(final ClassRoom classRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfClassRoom.handle(classRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateClass(final ClassRoom classRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfClassRoom.handle(classRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<ClassRoom>> getClassesByTeacher(final int teacherId) {
    final String _sql = "SELECT * FROM classes WHERE teacherId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teacherId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"classes"}, false, new Callable<List<ClassRoom>>() {
      @Override
      @Nullable
      public List<ClassRoom> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfClassCode = CursorUtil.getColumnIndexOrThrow(_cursor, "classCode");
          final List<ClassRoom> _result = new ArrayList<ClassRoom>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ClassRoom _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpClassCode;
            if (_cursor.isNull(_cursorIndexOfClassCode)) {
              _tmpClassCode = null;
            } else {
              _tmpClassCode = _cursor.getString(_cursorIndexOfClassCode);
            }
            _item = new ClassRoom(_tmpId,_tmpName,_tmpSubject,_tmpTeacherId,_tmpClassCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getClassByCode(final String code,
      final Continuation<? super ClassRoom> $completion) {
    final String _sql = "SELECT * FROM classes WHERE classCode = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (code == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, code);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ClassRoom>() {
      @Override
      @Nullable
      public ClassRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfClassCode = CursorUtil.getColumnIndexOrThrow(_cursor, "classCode");
          final ClassRoom _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpClassCode;
            if (_cursor.isNull(_cursorIndexOfClassCode)) {
              _tmpClassCode = null;
            } else {
              _tmpClassCode = _cursor.getString(_cursorIndexOfClassCode);
            }
            _result = new ClassRoom(_tmpId,_tmpName,_tmpSubject,_tmpTeacherId,_tmpClassCode);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getClassById(final int classId, final Continuation<? super ClassRoom> $completion) {
    final String _sql = "SELECT * FROM classes WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ClassRoom>() {
      @Override
      @Nullable
      public ClassRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfClassCode = CursorUtil.getColumnIndexOrThrow(_cursor, "classCode");
          final ClassRoom _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpSubject;
            if (_cursor.isNull(_cursorIndexOfSubject)) {
              _tmpSubject = null;
            } else {
              _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            }
            final int _tmpTeacherId;
            _tmpTeacherId = _cursor.getInt(_cursorIndexOfTeacherId);
            final String _tmpClassCode;
            if (_cursor.isNull(_cursorIndexOfClassCode)) {
              _tmpClassCode = null;
            } else {
              _tmpClassCode = _cursor.getString(_cursorIndexOfClassCode);
            }
            _result = new ClassRoom(_tmpId,_tmpName,_tmpSubject,_tmpTeacherId,_tmpClassCode);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
