package dcos.metronome.model

import scala.concurrent.duration._
import scala.collection.immutable._

case class Artifact(uri: String, extract: Boolean = true, executable: Boolean = false, cache: Boolean = false)

case class JobRunSpec(
  cpus:           Double              = JobRunSpec.DefaultCpus,
  mem:            Double              = JobRunSpec.DefaultMem,
  disk:           Double              = JobRunSpec.DefaultDisk,
  cmd:            Option[String]      = JobRunSpec.DefaultCmd,
  args:           Option[Seq[String]] = JobRunSpec.DefaultArgs,
  user:           Option[String]      = JobRunSpec.DefaultUser,
  env:            Map[String, String] = JobRunSpec.DefaultEnv,
  placement:      PlacementSpec       = JobRunSpec.DefaultPlacement,
  artifacts:      Seq[Artifact]       = JobRunSpec.DefaultArtifacts,
  maxLaunchDelay: Duration            = JobRunSpec.DefaultMaxLaunchDelay,
  docker:         Option[DockerSpec]  = JobRunSpec.DefaultDocker,
  volumes:        Seq[Volume]         = JobRunSpec.DefaultVolumes,
  restart:        RestartSpec         = JobRunSpec.DefaultRestartSpec
)

object JobRunSpec {
  val DefaultCpus: Double = 1.0
  val DefaultMem: Double = 128.0
  val DefaultDisk: Double = 0.0
  val DefaultPlacement = PlacementSpec()
  val DefaultMaxLaunchDelay = 1.hour
  val DefaultCmd = None
  val DefaultArgs = None
  val DefaultUser = None
  val DefaultEnv = Map.empty[String, String]
  val DefaultArtifacts = Seq.empty[Artifact]
  val DefaultDocker = None
  val DefaultVolumes = Seq.empty[Volume]
  val DefaultRestartSpec = RestartSpec()
}

