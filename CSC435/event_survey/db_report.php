<?php
// Database connection settings
$host = 'localhost';
$dbname = 'event_survey_db';
$username = 'survey_user'; 
$password = 'password';

try {
    // Create a single database connection
    $conn = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    
    // Get survey results
    $responses = $conn->query("SELECT * FROM responses ORDER BY submitted_at DESC")->fetchAll(PDO::FETCH_ASSOC);
    
    // Get chart data using a more efficient approach
    $chartData = [
        'ratings' => [],
        'interest' => []
    ];
    
    // query for rating counts
    $ratingData = $conn->query("SELECT rating, COUNT(*) as count FROM responses GROUP BY rating ORDER BY rating")->fetchAll(PDO::FETCH_ASSOC);
                       
    // query for interest counts
    $interestData = $conn->query("SELECT interest, COUNT(*) as count FROM responses GROUP BY interest")->fetchAll(PDO::FETCH_ASSOC);
    
    // Convert to JSON for JavaScript
    $ratingJson = json_encode($ratingData);
    $interestJson = json_encode($interestData);
    
// In case database connection fail
} catch(PDOException $e) {
    // Simple error handling
    $error = "Database error: " . $e->getMessage();
}

// Close connection
$conn = null;
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Survey Results Report</title>
    <link rel="stylesheet" href="db_report.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div class="container">
        <h1>Event Survey Results</h1>
        
        <?php if (isset($error)): ?>
            <div class="error"><?php echo $error; ?></div>
        <?php else: ?>
        
        <!-- Charts Section -->
        <div class="charts">
            <div class="chart">
                <h2>Ratings Distribution</h2>
                <canvas id="ratingChart"></canvas>
            </div>
            <div class="chart">
                <h2>Would Attend Again</h2>
                <canvas id="interestChart"></canvas>
            </div>
        </div>
        
        <!-- Results Table -->
        <h2>Survey Responses</h2>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Event Name</th>
                    <th>Event Type</th>
                    <th>Rating</th>
                    <th>Would Attend Again</th>
                    <th>Highlight</th>
                    <th>Submitted At</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($responses as $response): ?>
                <tr>
                    <td><?php echo htmlspecialchars($response['name']); ?></td>
                    <td><?php echo htmlspecialchars($response['event_name']); ?></td>
                    <td><?php echo htmlspecialchars($response['event_type']); ?></td>
                    <td><?php echo htmlspecialchars($response['rating']); ?></td>
                    <td><?php echo htmlspecialchars($response['interest']); ?></td>
                    <td><?php echo htmlspecialchars($response['highlight']); ?></td>
                    <td><?php echo htmlspecialchars($response['submitted_at']); ?></td>
                </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        
        <a href="event_survey.html" class="button">Submit New Survey</a>
        <?php endif; ?>
    </div>

    <?php if (!isset($error)): ?>
    <script>
        // Chart configurations
        const chartColors = {
            ratings: [
                'rgba(255, 99, 132, 0.7)',
                'rgba(255, 159, 64, 0.7)',
                'rgba(255, 205, 86, 0.7)',
                'rgba(75, 192, 192, 0.7)',
                'rgba(54, 162, 235, 0.7)'
            ],
            ratingsBorder: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)'
            ],
            interest: [
                'rgba(54, 162, 235, 0.7)',
                'rgba(255, 99, 132, 0.7)'
            ],
            interestBorder: [
                'rgb(54, 162, 235)',
                'rgb(255, 99, 132)'
            ]
        };

        // Parse the PHP data
        const ratingData = <?php echo $ratingJson; ?>;
        const interestData = <?php echo $interestJson; ?>;
        
        // Prepare chart data
        const ratingLabels = ratingData.map(item => `Rating ${item.rating}`);
        const ratingCounts = ratingData.map(item => item.count);
        const interestLabels = interestData.map(item => item.interest);
        const interestCounts = interestData.map(item => item.count);
        
        // Create Rating Chart
        new Chart(document.getElementById('ratingChart').getContext('2d'), {
            type: 'bar',
            data: {
                labels: ratingLabels,
                datasets: [{
                    label: 'Number of Responses',
                    data: ratingCounts,
                    backgroundColor: chartColors.ratings,
                    borderColor: chartColors.ratingsBorder,
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: { stepSize: 1 }
                    }
                }
            }
        });
        
        // Create Interest Chart
        new Chart(document.getElementById('interestChart').getContext('2d'), {
            type: 'pie',
            data: {
                labels: interestLabels,
                datasets: [{
                    data: interestCounts,
                    backgroundColor: chartColors.interest,
                    borderColor: chartColors.interestBorder,
                    borderWidth: 1
                }]
            },
            options: { responsive: true }
        });
    </script>
    <?php endif; ?>
</body>
</html>