package com.akshaylalsp.apistarter.repository
import com.akshaylalsp.apistarter.models.AnomalyDetection
import com.akshaylalsp.apistarter.models.LiveReading
import com.akshaylalsp.apistarter.models.PeakUsage
import com.google.firebase.database.*
import com.google.firebase.database.*

object FirebaseRepository {
    private val db = FirebaseDatabase.getInstance().reference.child("smartMeters")

    fun getLiveReading(clusterId: Int, meterId: Int, onDataChange: (LiveReading?) -> Unit) {
        db.child("cluster_$clusterId").child(meterId.toString()).child("liveReading")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data = snapshot.getValue(LiveReading::class.java)
                    onDataChange(data)
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    fun getAnomalyDetection(clusterId: Int, onDataChange: (AnomalyDetection?) -> Unit) {
        db.child("cluster_$clusterId").child("anomalyDetection")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists() && snapshot.childrenCount == 3L) {
                        val values = snapshot.value as List<Any>
                        val anomaly = values[0] as Boolean
                        val activeMeters = (values[1] as Long).toInt()
                        val totalMeters = (values[2] as Long).toInt()
                        onDataChange(AnomalyDetection(anomaly, activeMeters, totalMeters))
                    } else {
                        onDataChange(null)
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

    fun getPeakUsage(clusterId: Int, onDataChange: (PeakUsage?) -> Unit) {
        db.child("cluster_$clusterId").child("peakUsage")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists() && snapshot.childrenCount == 2L) {
                        val values = snapshot.value as List<Any>
                        val peak = values[0] as Boolean
                        val avgConsumption = values[1] as Double
                        onDataChange(PeakUsage(peak, avgConsumption))
                    } else {
                        onDataChange(null)
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }

}
