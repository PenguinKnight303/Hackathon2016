$(function() {

        Morris.Bar({
        element: 'usage-across-all-wards',
        data: [{
            wardName: 'Waiting Room',
            usage: 63,
            capacity: 70
        }, {
            wardName: 'Emergency Department',
            usage: 25,
            capacity: 30
        }, {
            wardName: 'General',
            usage: 78,
            capacity: 100
        }, {
            wardName: 'Ward 1',
            usage: 32,
            capacity: 40
        }, {
            wardName: 'Ward 2',
            usage: 16,
            capacity: 30
        }, {
            wardName: 'Ward 3',
            usage: 35,
            capacity: 40
        }, {
            wardName: 'Ward 4',
            usage: 8,
            capacity: 10
        }],
        xkey: 'wardName',
        ykeys: ['usage', 'capacity'],
        labels: ['Usage', 'Capacity'],
        pointSize: 2,
        hideHover: 'auto',
        //resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Download Sales",
            value: 12
        }, {
            label: "In-Store Sales",
            value: 30
        }, {
            label: "Mail-Order Sales",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2020',
            a: 50,
            b: 40
        }, {
            y: '2020',
            a: 75,
            b: 65
        }, {
            y: '2020',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });

});
