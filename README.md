# CPIK Present System 📱

A comprehensive **Android-based Student Attendance Management System** designed for educational institutions. This application enables teachers to efficiently manage and record student attendance digitally using Firebase Firestore and Google Authentication.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Key Features](#key-features)
- [Technology Stack](#technology-stack)
- [System Architecture](#system-architecture)
- [Installation & Setup](#installation--setup)
- [Usage Guide](#usage-guide)
- [Database Structure](#database-structure)
- [Project Structure](#project-structure)
- [Code Quality](#code-quality)
- [Contributing](#contributing)
- [License](#license)

---

## 🎯 Project Overview

CPIK Present System is a mobile application developed for CPIK (an educational institution) to digitize the attendance management process. It provides:

- **Real-time attendance recording** with Firestore synchronization
- **User authentication** via Google Sign-In
- **Role-based access** for teachers and students
- **Intuitive UI** with custom components for ease of use
- **Network connectivity monitoring** for offline-awareness
- **Secure data storage** with hierarchical organization

**Primary Users:** Teachers managing classroom attendance  
**Languages:** Java (78.3%), Jupyter Notebook (21.7%)  
**Development Status:** Active (Last updated: January 23, 2025)

---

## ✨ Key Features

### 👨‍🏫 Teacher Functions

#### 1. **Class Setup**
- Select department and semester from dropdowns
- Enter 4-digit subject code
- Choose attendance date using an interactive horizontal calendar widget
- Supports date ranges ±1 month from current date

#### 2. **Student Roster Management**
- View all enrolled students in a RecyclerView list
- Real-time display with smooth animations
- Touch-based interactions for attendance marking
- Customizable list item layouts

#### 3. **Attendance Recording**
- Toggle-based UI for marking students Present/Absent
- Real-time sync with Firestore database
- Instant feedback with custom styled notifications
- Batch operations support

#### 4. **Student Data Management**
- Create new student records
- Bulk student import from school servers (JSON parsing)
- Retrieve student lists by:
  - Department
  - Semester
  - Subject Code
  - Date

#### 5. **Network Connectivity**
- Real-time network status monitoring
- Offline awareness notifications
- Graceful error handling for:
  - Timeouts
  - Connection failures
  - Server errors
  - Parse errors

### 🎨 UI/UX Features

- **Custom Horizontal Calendar** - Intuitive date selection with visual feedback
- **Stylized Toggle Switch** - Modern on/off controls for attendance marking
- **Custom Toast Notifications** - Enhanced notifications with:
  - Multiple color schemes (success, failure, loading)
  - Custom borders and rounded corners
  - Configurable gravity and duration
- **Splash Screen Animations** - Terminal-style animations on app launch
- **Responsive RecyclerView** - Efficient list rendering with dividers

---

## 🛠 Technology Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Firebase Firestore, Google Firebase Authentication |
| **Frontend** | Android (Java 8+) |
| **UI Framework** | AndroidX, Android Support Library |
| **Networking** | Volley HTTP Client, Firebase SDK |
| **Data Format** | JSON, Firebase Documents |
| **Libraries** | HorizontalCalendar, Custom UI Components |
| **Version Control** | Git/GitHub |

### Dependencies

```gradle
// Firebase
implementation 'com.google.firebase:firebase-firestore'
implementation 'com.google.firebase:firebase-auth'

// Android
implementation 'androidx.appcompat:appcompat'
implementation 'androidx.recyclerview:recyclerview'
implementation 'androidx.cardview:cardview'

// Networking
implementation 'com.android.volley:volley'

// Custom Libraries
implementation 'devs.mulham.horizontalcalendar:horizontalcalendar'
```

---

## 🏗 System Architecture

### Workflow Diagram

```
Teacher Login (Google Auth)
       ↓
Select Class (Department, Semester, Subject Code, Date)
       ↓
Load Student Roster from Firestore
       ↓
Display Students in RecyclerView
       ↓
Mark Attendance (Toggle Switch)
       ↓
Submit Attendance Record
       ↓
Store in Firestore (Real-time Sync)
       ↓
Confirmation Alert
```

### Activity Flow

```
SplashScreen_Activity
       ↓
LoginActivity (Google Auth)
       ↓
Teachers_Panel / GeneralUser_Profile
       ↓
Teacher_Class_type (Select Class Info)
       ↓
ViewStdInfo_RecycleView (Mark Attendance)
       ↓
Post_Students_Attendance (Confirm & Submit)
```

---

## 📲 Installation & Setup

### Prerequisites

- Android Studio (latest version)
- JDK 8 or higher
- Google Play Services
- Firebase project with Firestore enabled
- Git

### Step 1: Clone the Repository

```bash
git clone https://github.com/MBayezid/CPIK_Present_System.git
cd CPIK_Present_System
```

### Step 2: Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Create a new project
3. Add Android app to your project
4. Download `google-services.json`
5. Place it in `app/` directory:
   ```
   app/google-services.json
   ```

### Step 3: Enable Firebase Services

In Firebase Console:
- ✅ Enable Firestore Database
- ✅ Enable Google Sign-In authentication
- ✅ Set Firestore security rules (see section below)

### Step 4: Build & Run

```bash
# Open in Android Studio
android-studio .

# Or build from command line
./gradlew build
./gradlew installDebug
```

### Step 5: Configure Permissions

The app requires:
- `INTERNET` - For Firebase and API calls
- `ACCESS_NETWORK_STATE` - For connectivity monitoring

(Already declared in `AndroidManifest.xml`)

---

## 📖 Usage Guide

### For Teachers

#### 1. **Login**
   - Launch the app
   - Click "Sign in with Google"
   - Authenticate with your institutional email
   - Proceed to Teachers Panel

#### 2. **Initiate Attendance**
   - Navigate to "Mark Attendance"
   - Select **Department** from dropdown
   - Select **Semester** from dropdown
   - Enter **4-digit Subject Code**
   - Choose **Date** from horizontal calendar
   - Click **Confirm**

#### 3. **Mark Attendance**
   - View list of enrolled students
   - For each student:
     - Toggle the switch to mark **Present** (green/on)
     - Keep toggle off to mark **Absent** (gray/off)
   - Instant Firestore sync occurs for each change

#### 4. **Submit Attendance**
   - After marking all students
   - Click **Submit Attendance**
   - Confirm the action in alert dialog
   - System displays success notification
   - Attendance data saved to Firestore

#### 5. **Create Student Records** (Optional)
   - Navigate to "Create Student"
   - Enter student details (Name, Roll Number, Registration, etc.)
   - Select Department and Semester
   - Submit to add to system

---

## 🗄 Database Structure

### Firestore Collections

#### 1. **AttBook** - Attendance Records
```
AttBook/
├── {SubjectCode}/
│   ├── {Date}/
│   │   ├── {StudentRoll}/
│   │   │   ├── StudentName: String
│   │   │   ├── WasPresent: Boolean
│   │   │   ├── ClassRoll: String
│   │   │   ├── BoardRoll: String
│   │   │   ├── Registration: String
│   │   │   └── Semester: String
```

#### 2. **students_collection** - Student Master Data
```
students_collection/
├── {Department}/
│   ├── {TechnologyName}/
│   │   ├── {ClassRoll}/
│   │   │   ├── StudentName: String
│   │   │   ├── ClassRoll: String
│   │   │   ├── BoardRoll: String
│   │   │   ├── Registration: String
│   │   │   └── Semester: String
```

#### 3. **{TeacherEmail}** - Teacher's Custom Data
```
{TeacherEmail}/
├── {StudentRoll}/
│   ├── Subject_Code/
│   │   └── Subject records...
```

### Document Examples

**Attendance Record:**
```json
{
  "StudentName": "Ahmed Hassan",
  "WasPresent": true,
  "ClassRoll": "1001",
  "BoardRoll": "5001",
  "Registration": "2021001",
  "Semester": "6th"
}
```

**Student Master Record:**
```json
{
  "StudentName": "Ahmed Hassan",
  "ClassRoll": "1001",
  "BoardRoll": "5001",
  "Registration": "2021001",
  "Semester": "6th"
}
```

---

## 📂 Project Structure

```
CPIK_Present_System/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/bayazid/cpik_present_system/
│   │   │   │   ├── Auth_Profile/           # Authentication & Login
│   │   │   │   │   ├── LoginActivity.java
│   │   │   │   │   ├── Auth_MainActivity.java
│   │   │   │   │   ├── Teachers_Panel.java
│   │   │   │   │   └── GeneralUser_Profile.java
│   │   │   │   │
│   │   │   │   ├── Teachears_Function/    # Teacher Features
│   │   │   │   │   ├── Teacher_Class_type.java
│   │   │   │   │   ├── ViewStdInfo_RecycleView.java
│   │   │   │   │   ├── Post_Students_Attendance.java
│   │   │   │   │   ├── Create_Student.java
│   │   │   │   │   ├── Attendance_Book_Main.java
│   │   │   │   │   └── Attendance_Book_Child_1.java
│   │   │   │   │
│   │   │   │   ├── Scan_Cpik_Server/     # Server Integration
│   │   │   │   │   └── Get_Student_Group_JSON.java
│   │   │   │   │
│   │   │   │   ├── Network_Cheaker/      # Network & Connectivity
│   │   │   │   │   ├── ConnectivityReceiver.java
│   │   │   │   │   ├── BitmapCache.java
│   │   │   │   │   └── MyApplicationController.java
│   │   │   │   │
│   │   │   │   ├── DATA_SECTOR/           # Data Models
│   │   │   │   │   ├── Std_Data_set.java
│   │   │   │   │   └── Date_set.java
│   │   │   │   │
│   │   │   │   ├── SplashScreen_Activity.java
│   │   │   │   ├── Students_List.java
│   │   │   │   └── GetStudentDocuments.java
│   │   │   │
│   │   │   ├── res/
│   │   │   │   ├── layout/              # UI Layouts (XML)
│   │   │   │   ├── drawable/            # Icons & Images
│   │   │   │   ├── values/              # Strings, Colors, Themes
│   │   │   │   └── menu/                # Menu Resources
│   │   │   │
│   │   │   └── AndroidManifest.xml      # App Configuration
│   │   │
│   │   └── test/                        # Unit Tests
│   │
│   ├── build.gradle                      # App Build Configuration
│   └── google-services.json              # Firebase Configuration
│
├── librarycpik/                         # Custom UI Library Module
│   ├── src/main/java/com/bayazid/librarycpik/
│   │   ├── CustomizedToast/              # Custom Toast Component
│   │   │   └── CT.java
│   │   │
│   │   ├── TerminalAnimation/            # Splash Screen Animations
│   │   │   ├── SplashScreen.java
│   │   │   ├── TerminalAnimation.java
│   │   │   └── DrawingMaster.java
│   │   │
│   │   └── ToggleSwitchView/             # Custom Toggle Switch
│   │       └── MyToggleButton.java
│   │
│   └── build.gradle
│
├── build.gradle                         # Project-level Build Configuration
├── settings.gradle                      # Gradle Settings
├── README.md                            # This File
└── .gitignore                           # Git Ignore Rules
```

### Key Directories

| Directory | Purpose |
|-----------|---------|
| `Auth_Profile/` | Google Auth & Login Management |
| `Teachears_Function/` | Attendance marking & class management |
| `Scan_Cpik_Server/` | Server API integration for bulk student import |
| `Network_Cheaker/` | Network monitoring & caching |
| `DATA_SECTOR/` | Data models and POJO classes |
| `librarycpik/` | Reusable custom UI components |

---

## 💻 Code Quality

### Strengths ✅

- **Modular Architecture** - Separated concerns by feature (Auth, Teachers, Network)
- **Firebase Integration** - Real-time Firestore synchronization
- **Custom UI Components** - Reusable components in dedicated library module
- **Network Error Handling** - Comprehensive error handling for API failures
- **Role-Based Access** - Separate flows for teachers and students

### Areas for Improvement ⚠️

- **Naming Consistency** - "Teachears" instead of "Teachers" (typo)
- **Architecture Pattern** - Could benefit from MVVM/MVP pattern
- **Error Logging** - Limited logging for debugging and monitoring
- **Offline Support** - No built-in offline-first data synchronization
- **Unit Tests** - Limited test coverage
- **Documentation** - Inline code comments could be more extensive

### Recommendations for Enhancement

1. **Migrate to MVVM** - Use ViewModel and LiveData for better separation of concerns
2. **Add Unit Tests** - Test critical business logic
3. **Implement Room Database** - Local caching for offline functionality
4. **Add Logging** - Use Timber or Firebase Crashlytics
5. **Fix Typos** - Rename "Teachears_Function" to "Teachers_Function"
6. **Version Control** - Add semantic versioning to releases

---

## 🔒 Firebase Security Rules

Recommended Firestore security rules:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Allow teachers to read/write their own attendance records
    match /AttBook/{subjectCode}/{date}/{document=**} {
      allow read, write: if request.auth != null;
    }
    
    // Allow authenticated users to read student collection
    match /students_collection/{department}/{technology}/{classRoll} {
      allow read: if request.auth != null;
      allow write: if request.auth.token.admin == true;
    }
    
    // Teacher's personal data
    match /{teacherEmail}/{document=**} {
      allow read, write: if request.auth.token.email == teacherEmail;
    }
  }
}
```

---

## 🤝 Contributing

We welcome contributions! To contribute:

1. **Fork** the repository
2. **Create** a feature branch: `git checkout -b feature/YourFeature`
3. **Commit** your changes: `git commit -m 'Add YourFeature'`
4. **Push** to the branch: `git push origin feature/YourFeature`
5. **Submit** a Pull Request

### Contribution Guidelines

- Follow Java naming conventions
- Add comments for complex logic
- Test thoroughly before submitting PR
- Update README.md if adding new features

---

## 📝 License

This project is developed for CPIK educational institution. For licensing inquiries, please contact the repository owner.

---

## 👥 Authors & Credits

- **Developer:** MBayezid
- **Institution:** CPIK
- **Last Updated:** January 23, 2025

---

## 📞 Support & Feedback

For issues, questions, or suggestions:

1. **GitHub Issues** - Open an issue on the repository
2. **Email** - Contact the development team
3. **Documentation** - Check the docs/ directory for detailed guides

---

## 🚀 Future Roadmap

- [ ] Mobile app version for students to check attendance
- [ ] Analytics dashboard for attendance trends
- [ ] SMS/Email notifications for attendance summary
- [ ] Offline attendance recording with sync
- [ ] Attendance reports in PDF format
- [ ] Integration with student information system (SIS)
- [ ] Biometric attendance marking
- [ ] Multi-language support

---

## 📚 Additional Resources

- [Firebase Firestore Documentation](https://firebase.google.com/docs/firestore)
- [Google Sign-In for Android](https://developers.google.com/identity/sign-in/android)
- [Android RecyclerView Guide](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [Android Best Practices](https://developer.android.com/guide)

---

**Happy Contributing! 🎉**
