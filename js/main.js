function SendDate()
{

  // Get date & time from user input
  var date = document.getElementById("date-input").value;
  //var time = document.getElementById("time-input").value;
  //datetime = date + " " + time;

  // Display date in header of chart panel
  $("#date-selected").text(date);

	var nReloads = 0;

	var graph = Morris.Bar({
	    element: 'test',
	    data: JSON.parse(text),
	    xkey: 'wardName',
	    ykeys: ['usage', 'capacity'],
	    labels: ['Usage', 'Capacity'],
	    parseTime: false,
        pointSize: 2,
        hideHover: 'auto',
        resize: true
	});

	function update() {
	  nReloads++;
	  graph.setData(data(5 * nReloads));
	  $('#reloadStatus').text(nReloads + ' reloads');
	}
	setInterval(update, 100);

	Morris.Bar({
        element: 'usage-across-all-wards',
        data: [{
            wardName: 'Waiting Room',
            usage: 50//wardData.wards.patient_num[0],
            capacity: 70
        }, {
            wardName: 'Emergency Department',
            usage: 50//wardData.wards.patient_num[1],
            capacity: 30
        }, {
            wardName: 'General',
            usage: 50//wardData.wards.patient_num[2],
            capacity: 100
        }, {
            wardName: 'Ward 1',
            usage: 50//wardData.wards.patient_num[3],
            capacity: 40
        }, {
            wardName: 'Ward 2',
            usage: 50//wardData.wards.patient_num[4],
            capacity: 30
        }, {
            wardName: 'Ward 3',
            usage: 50//wardData.wards.patient_num[5],
            capacity: 40
        }, {
            wardName: 'Ward 4',
            usage: 50//wardData.wards.patient_num[6]
            capacity: 10
        }],
        xkey: 'wardName',
        ykeys: ['usage', 'capacity'],
        labels: ['Usage', 'Capacity'],
        pointSize: 2,
        hideHover: 'auto',
        //resize: true
    });

}