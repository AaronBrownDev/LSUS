document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('surveyForm');
    
    form.addEventListener('submit', function(event) {
        // Prevent form from submitting by default
        event.preventDefault();
        
        // Reset all error messages
        const errorElements = document.querySelectorAll('.error');
        errorElements.forEach(function(element) {
            element.style.display = 'none';
        });
        
        // Default form as valid
        let isValid = true;
        
        // Validate name
        const name = document.getElementById('name').value.trim();
        if (name === '') {
            isValid = false;
        }
        
        // Validate email
        const email = document.getElementById('email').value.trim();
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === '' || !emailPattern.test(email)) {
            isValid = false;
        }
        
        // Validate event name
        const eventName = document.getElementById('event_name').value.trim();
        if (eventName === '') {
            isValid = false;
        }
        
        // Validate event type
        const eventType = document.getElementById('event_type').value;
        if (eventType === '') {
            isValid = false;
        }
        
        // Validate rating
        const ratingSelected = document.querySelector('input[name="rating"]:checked');
        if (!ratingSelected) {
            isValid = false;
        }
        
        // Validate interest
        const interestSelected = document.querySelector('input[name="interest"]:checked');
        if (!interestSelected) {
            isValid = false;
        }
        
        // Validate highlight
        const highlight = document.getElementById('highlight').value.trim();
        if (highlight === '') {
            isValid = false;
        }
        
        // If form is valid, submit it
        if (isValid) {
            form.submit();
        }
    });
});