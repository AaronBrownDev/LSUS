<?php
// Database connection settings
$host = 'localhost';
$dbname = 'event_survey_db';
$username = 'survey_user'; 
$password = 'password';

// Function to sanitize input data
function sanitize($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

// Check if form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get and sanitize form data
    $name = isset($_POST['name']) ? sanitize($_POST['name']) : '';
    $email = isset($_POST['email']) ? sanitize($_POST['email']) : '';
    $event_name = isset($_POST['event_name']) ? sanitize($_POST['event_name']) : '';
    $event_type = isset($_POST['event_type']) ? sanitize($_POST['event_type']) : '';
    $rating = isset($_POST['rating']) ? (int)$_POST['rating'] : 0;
    $interest = isset($_POST['interest']) ? sanitize($_POST['interest']) : '';
    $highlight = isset($_POST['highlight']) ? sanitize($_POST['highlight']) : '';
    
    // Validate the data
    $errors = [];
    
    if (empty($name)) {
        $errors[] = "Name is required";
    }
    
    if (empty($email) || !filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors[] = "Valid email is required";
    }
    
    if (empty($event_name)) {
        $errors[] = "Event name is required";
    }
    
    if (empty($event_type)) {
        $errors[] = "Event type is required";
    }
    
    if ($rating < 1 || $rating > 5) {
        $errors[] = "Rating must be between 1 and 5";
    }
    
    if ($interest !== 'Yes' && $interest !== 'No') {
        $errors[] = "Interest must be Yes or No";
    }
    
    if (empty($highlight)) {
        $errors[] = "Highlight is required";
    }
    
    // If no validation errors, proceed with database insertion
    if (empty($errors)) {
        try {
            // Create database connection
            $conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
            
            // Set PDO error mode to exception
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            
            // Prepare SQL statement
            $stmt = $conn->prepare("INSERT INTO responses (name, email, event_name, event_type, rating, interest, highlight) VALUES (:name, :email, :event_name, :event_type, :rating, :interest, :highlight)");
            
            // Bind parameters
            $stmt->bindParam(':name', $name);
            $stmt->bindParam(':email', $email);
            $stmt->bindParam(':event_name', $event_name);
            $stmt->bindParam(':event_type', $event_type);
            $stmt->bindParam(':rating', $rating);
            $stmt->bindParam(':interest', $interest);
            $stmt->bindParam(':highlight', $highlight);
            
            // Execute the statement
            $stmt->execute();
            
            // Redirect to confirmation page or report page
            header("Location: db_report.php");
            exit();
        } catch(PDOException $e) {
            echo "Error: " . $e->getMessage();
        }
        
        // Close connection
        $conn = null;
    } else {
        // Display validation errors
        echo "<h2>Validation Errors:</h2>";
        echo "<ul>";
        foreach ($errors as $error) {
            echo "<li>$error</li>";
        }
        echo "</ul>";
        echo "<p><a href='event_survey.html'>Go Back</a></p>";
    }
}
?>